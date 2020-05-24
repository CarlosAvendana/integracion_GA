package com.e.lab.AccesoDatos;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class InterfazConnection {

    String URL;
    String accion;
    String objeto;
    MyAsyncTasks _myAsync;
    ProgressDialog progressDialog;

    public InterfazConnection(String URL, String accion, String objeto) {
        this.URL = URL;
        this.accion = accion;
        this.objeto = objeto;
        this._myAsync = new MyAsyncTasks();
        _myAsync.setServer(URL);
    }

    public class MyAsyncTasks extends AsyncTask<String, String, String> {
        String path = "192.168.0.17";
        String server;
        String puerto = "8084";
        String apiUrl = "http://" + path + ":" + puerto + "/GestionAcademica/" + server;

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public String getServer() {
            return server;
        }

        public void setServer(String server) {
            this.server = server;
        }

        public String getPuerto() {
            return puerto;
        }

        public void setPuerto(String puerto) {
            this.puerto = puerto;
        }

        public String getApiUrl() {
            return apiUrl;
        }

        public void setApiUrl(String apiUrl) {
            this.apiUrl = apiUrl;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // display a progress dialog for good user experiance
            // progressDialog = new ProgressDialog(MainActivity.this);
            // progressDialog.setMessage("Please Wait");
            // progressDialog.setCancelable(false);
            // progressDialog.show();
        }

        protected String doInBackground(String... params) {

            // implement API in background and store the response in current variable
            String current = "";

            JSONObject jsonObject = new JSONObject();
/*
            try {
                jsonObject.put("id", "110470816");
                jsonObject.put("nombre", "JuanDeDios-MurilloMorera");
            } catch (JSONException e) {
                e.printStackTrace();
            }
  */
            // apiUrl+="?opc=1&id=110470816";
            // apiUrl += "?profe=" + jsonObject.toString();

            try {
                URL url;
                HttpURLConnection urlConnection = null;
                try {
                    url = new URL(apiUrl);

                    urlConnection = (HttpURLConnection) url
                            .openConnection();

                    InputStream in = urlConnection.getInputStream();

                    InputStreamReader isw = new InputStreamReader(in);

                    int data = isw.read();
                    while (data != -1) {
                        current += (char) data;
                        data = isw.read();
                        System.out.print(current);

                    }
                    // return the data to onPostExecute method
                    return current;

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (urlConnection != null) {
                        urlConnection.disconnect();
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
                return "Exception: " + e.getMessage();
            }
            Log.d("Current", current);
            return current;
        }

        @Override
        protected void onPostExecute(String s) {
            Log.d("data_JSON", s.toString());
            // dismiss the progress dialog after receiving data from API
            progressDialog.dismiss();
            //T.setText(s.toString());
            //Json
        }

    }// Cierre clase MyAsynk


}// Cierra clase connection
