package com.example.nikhi.gissurveyapp;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Address;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import com.esri.android.map.FeatureLayer;
import com.esri.android.map.GraphicsLayer;
import com.esri.android.map.MapView;
import com.esri.android.map.ags.ArcGISTiledMapServiceLayer;
import com.esri.core.geodatabase.GeodatabaseFeatureServiceTable;
import com.esri.core.geometry.Point;
import com.esri.core.geometry.SpatialReference;
import com.esri.core.map.Graphic;
import com.esri.core.symbol.SimpleMarkerSymbol;
import com.esri.core.tasks.geocode.Locator;
import com.esri.core.tasks.geocode.LocatorReverseGeocodeResult;
import com.esri.core.geometry.GeometryEngine;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;


public class MainActivity extends AppCompatActivity {
    private Button mapLoad;
    private Button rGeocode;
    FloatingActionButton fab;
    MapView mMapView = null;
    final String FEATURE_LAYER_URL = "http://maps2.dcgis.dc.gov/dcgis/rest/services/DCGIS_APPS/Real_Property_Application/MapServer";
    public FeatureLayer featureLayer;
    public GeodatabaseFeatureServiceTable featureServiceTable;
    public ArcGISTiledMapServiceLayer tiled_layer=null;
    public GraphicsLayer gl=null;
    public LocationManager gps=null;
    public LocationListener locationListener=null;
    public Locator loc=null;
    public  SpatialReference sr;
    public Point mapPoint;
    Map<String,String> addressFields;
    String[] result_details=new String[3];
    double x=0.0;      //STATIC OR DUMMY LAT
    double y=0.0;      //STATIC OR DUMMY LONG
    double latitude=0.0;   //STORE LAT
    double longitude=0.0;   //STORE LONG
    public GeometryEngine geom;  //USED TO CONVER LAT LONG IN WGS TO CUSTOM CO-ORDINATES
    Point projected_location; //USED TO SEND THE CURRENT LOCATION TO DATA ACTIVITY
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        rGeocode=(Button)findViewById(R.id.geocode);
        rGeocode.setEnabled(false);
        rGeocode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(latitude!=0.0&&longitude!=0.0)
                {
                    if(loc==null)
                    {
                        loc=Locator.createOnlineLocator("http://maps2.dcgis.dc.gov/dcgis/rest/services/DCGIS_APPS/DCGIS_MAR/GeocodeServer");
                        x=405452.1073964834;
                        y=136488.4160027206;
                        mapPoint=new Point(x,y);
                        Graphic g = new Graphic(mapPoint, new SimpleMarkerSymbol(Color.BLUE, 10, SimpleMarkerSymbol.STYLE.CIRCLE));
                        gl.addGraphic(g);
                        sr=mMapView.getSpatialReference();
                        reverseGeocodeTask ayncQuery = new reverseGeocodeTask();
                        ayncQuery.execute();


                    }
                }
                else Toast.makeText(MainActivity.this,"Location Not Found...Try in some time",Toast.LENGTH_SHORT).show();
            }
        });
        mapLoad=(Button)findViewById(R.id.load_map);
       // pointPlace=(Button)findViewById(R.id.place_point);
        mMapView=(MapView)findViewById(R.id.map);
        mMapView.setEsriLogoVisible(false);
        mapLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
if(tiled_layer==null) {
   // Toast.makeText(MainActivity.this, "Adding Basemap", Toast.LENGTH_SHORT).show();
    tiled_layer = new ArcGISTiledMapServiceLayer("http://maps2.dcgis.dc.gov/dcgis/rest/services/DCGIS_DATA/DC_Basemap/MapServer");
    mMapView.addLayer(tiled_layer);
}
                else
    Toast.makeText(MainActivity.this, "Basemap already added to map", Toast.LENGTH_SHORT).show();
               /* featureServiceTable = new GeodatabaseFeatureServiceTable(FEATURE_LAYER_URL, 4);
                featureServiceTable.initialize(new CallbackListener<GeodatabaseFeatureServiceTable.Status>() {

                    @Override
                    public void onCallback(GeodatabaseFeatureServiceTable.Status status) {
                        featureLayer = new FeatureLayer(featureServiceTable);
                       // mMapView.addLayer(featureLayer); FEATURE LAYER ADDITION IS COMMENTED OUT ONLY BASEMAP IS ADDED
                       // setContentView(mMapView);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        Toast.makeText(MainActivity.this,"Error initializing FeatureServiceTable",Toast.LENGTH_SHORT).show();
                    }
                });*/

                //***CHECKING GPS STATUS
if(gl==null)
{
    gl=new GraphicsLayer();
    mMapView.addLayer(gl);
}
                gps=(LocationManager) getApplicationContext().getSystemService(Context.LOCATION_SERVICE);
                boolean gps_enabled=gps.isProviderEnabled(LocationManager.GPS_PROVIDER);
                if(gps_enabled==true)
                {
                    Toast.makeText(MainActivity.this,"GPS Enabled...Fetching Current Location",Toast.LENGTH_SHORT).show();
                    getLocation();
                }
                    else
                {
                    Toast.makeText(MainActivity.this,"GPS Disabled...Turn ON GPS and try again",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                }

            }
        });
    }
public void getLocation()
{
locationListener=new LocationListener() {
    @Override
    public void onLocationChanged(Location location) {


         latitude=location.getLatitude();
         longitude=location.getLongitude();

        geom=new GeometryEngine();

         projected_location=  geom.project(latitude,longitude,mMapView.getSpatialReference());

        //Toast.makeText(MainActivity.this,"Projected Location "+projected_location.toString(),Toast.LENGTH_SHORT).show();
        //Toast.makeText(MainActivity.this,"Lat: "+latitude+" Long: "+longitude,Toast.LENGTH_SHORT).show();
        rGeocode.setEnabled(true);
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
};
    //PERMISSION CHECKING HANDLER
    int permissionCheck = ContextCompat.checkSelfPermission(MainActivity.this,
            Manifest.permission.ACCESS_COARSE_LOCATION);

    int permissionCheck1 = ContextCompat.checkSelfPermission(MainActivity.this,
            Manifest.permission.ACCESS_FINE_LOCATION);
//    if(permissionCheck== PackageManager.PERMISSION_GRANTED&&permissionCheck1== PackageManager.PERMISSION_GRANTED)
//    {
        gps.requestLocationUpdates(gps.NETWORK_PROVIDER,0,0,locationListener);
//    }


}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    //ASYNC TASK CLASS
    private class reverseGeocodeTask extends AsyncTask<Point, Void, LocatorReverseGeocodeResult> {
        LocatorReverseGeocodeResult result = null;

        protected void onProgressUpdate() {

        }

        @Override
        protected LocatorReverseGeocodeResult doInBackground(Point... params) {

            try {
                result = loc.reverseGeocode(mapPoint,50,
                        sr,sr);
            } catch (Exception e) {
                e.printStackTrace();
            }
return result;

        }

        protected void onPostExecute(LocatorReverseGeocodeResult result) {
            addressFields = result.getAddressFields();
            StringBuilder address = new StringBuilder();
            for(Map.Entry<String,String> entry : addressFields.entrySet())
                address.append(entry.getValue() != null ? entry.getValue() + " " : "");

            //Toast.makeText(MainActivity.this,"Address:  "+addressFields.get("Address").toString()+"  "+addressFields.get("City").toString()+"  "+addressFields.get("Region").toString(),Toast.LENGTH_SHORT).show();

            result_details[0]=addressFields.get("Address").toString();
            result_details[1]=addressFields.get("City").toString();
            result_details[2]=addressFields.get("Region").toString();

            ArrayList<String> result_details_list = new ArrayList<String>(Arrays.asList(result_details));
            Intent intent=new Intent(MainActivity.this,DataActivity.class);

            Double converted_x=projected_location.getX();
            Double converted_y=projected_location.getY();
            intent.putStringArrayListExtra("result_details",result_details_list);
            intent.putExtra("converted_x",converted_x);
            intent.putExtra("converted_y",converted_y);
            startActivity(intent);






        }
    }

}
