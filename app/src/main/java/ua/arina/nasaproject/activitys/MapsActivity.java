package ua.arina.nasaproject.activitys;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.android.geojson.GeoJsonLayer;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import ua.arina.nasaproject.R;
import ua.arina.nasaproject.interfaces.FloodsAPIInterface;
import ua.arina.nasaproject.models.floodsdata.FloodsData;
import ua.arina.nasaproject.models.floodsdata.Item;

import static ua.arina.nasaproject.BuildConfig.DEBUG;
import static ua.arina.nasaproject.utils.settings.Constants.BASE_URL;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback,
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        LocationListener {

    private final String TAG = getClass().getSimpleName();

    private final int LOCATION_PERMISSIONS_REQUEST_CODE_SET_UP_MANAGER = 0;
    private final int LATLNG_ZOOM = 10;

    private GoogleMap map;
    private LocationManager locationManager;
    private GoogleApiClient googleApiClient;
    private ConnectivityManager connectivityManager;
    private Retrofit client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        googleApiClient = new GoogleApiClient
                .Builder(this)
                .addApi(Places.GEO_DATA_API)
                .addApi(Places.PLACE_DETECTION_API)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .build();

        client = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        locationManager = (LocationManager)
                this.getSystemService(Context.LOCATION_SERVICE);

        connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        setUpLocationListener();
    }

    @Override
    protected void onStart() {
        googleApiClient.connect();
        super.onStart();
    }

    private void setUpLocationListener() {

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            locationManager.requestLocationUpdates(
                    LocationManager.GPS_PROVIDER,
                    5000,
                    10,
                    this);
        } else {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    LOCATION_PERMISSIONS_REQUEST_CODE_SET_UP_MANAGER);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {

        if (requestCode == LOCATION_PERMISSIONS_REQUEST_CODE_SET_UP_MANAGER){
            if (grantResults.length != 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                setUpLocationListener();
            }
        }

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;

        if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED
                    && locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER) != null) {

                LatLng location =
                        new LatLng(locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)
                                .getLatitude(),
                                locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)
                                        .getLongitude());
                map.clear();
                map.addMarker(new MarkerOptions().position(location).title("You are here"));
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(location, LATLNG_ZOOM));
            }
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        if (map != null){
            LatLng user_LatLng = new LatLng(location.getLatitude(), location.getLongitude());
            map.addMarker(new MarkerOptions().position(user_LatLng).title("You are here"));
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(user_LatLng, LATLNG_ZOOM));
        }

        if (DEBUG) {
            Log.d(TAG, "loc chan: ");
        }

        Geocoder geoCoder =
                new Geocoder(getBaseContext(), Locale.ENGLISH);

        try {
            List<Address> addresses = geoCoder
                    .getFromLocation(location.getLatitude(), location.getLongitude(), 5);
            if (addresses.get(0).getLocality() != null){
                takeFloodsData(addresses.get(0).getLocality());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {
        googleApiClient.reconnect();
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    protected void onStop() {
        googleApiClient.disconnect();
        super.onStop();
    }

    private void takeFloodsData(String c){

        new Thread(()-> {
            FloodsAPIInterface service = client.create(FloodsAPIInterface.class);
            Call<String> floodsResult = service.getFloodsData(c);

            try {
                Gson gson = (new GsonBuilder()).create();
                FloodsData fd = gson.fromJson(floodsResult.execute().body(), FloodsData.class);
                List<Item> items = fd.getItems();
                if (DEBUG) {
                    Log.d(TAG, items.toString());
                }

                for (Item item : items) {
                    if (DEBUG) {
                        Log.d(TAG, item.toString());
                    }
                    Call<String> poligonString = service.getGeoJSON(item.getFloodAreaID());
                    JSONObject geoJSON = new JSONObject(poligonString.execute().body());
                    runOnUiThread(() ->{
                        if (DEBUG) {
                            Log.d(TAG, geoJSON.toString());
                        }
                        GeoJsonLayer geoL = new GeoJsonLayer(map, geoJSON);
                        geoL.getDefaultPolygonStyle().setStrokeColor(Color.RED);
                        geoL.getDefaultPolygonStyle().setStrokeWidth(10);
                        geoL.getDefaultPolygonStyle().setFillColor(Color.BLUE);
                        geoL.getDefaultLineStringStyle().setClickable(true);
                        geoL.getDefaultPointStyle().setTitle(item.getDescription());
                        geoL.addLayerToMap();
                    });
                }
            } catch (IOException | JSONException e) {
                e.printStackTrace();
                if (DEBUG) {
                    Log.d(TAG, "errr: ");
                }
            }
        }).start();
    }
}
/**
 * Copyright 2017 Oryna Starkina
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    ttp://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */