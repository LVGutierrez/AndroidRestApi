# AndroidRestApi

<h2>Usage</h2>
<p>Make a REST API call using Java.</p>

<h2>Java</h2>

<pre>
<code>

 @Override
    protected final String doInBackground(ArrayList<String>... arrayLists) {

        // API Manager

        try {

            String api = "add api url in this string";

            URL url = new URL(api);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            try {

                BufferedReader buffer = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                StringBuilder builder = new StringBuilder();
                String line;

                while ((line = buffer.readLine()) != null) {
                    builder.append(line).append("\n");
                }

                buffer.close();
                return builder.toString();

            }

            finally {
                urlConnection.disconnect();
            }

        } catch(Exception error) {
            Log.e("Api Error", error.getMessage(), error);
            return null;
        }

    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String data) {
        super.onPostExecute(data);

        if(data == null) {
            data = "There's an error.";
        }

        try {

            // Parse data
            JSONObject object = new JSONObject(data);

            // get json objects here

        } catch (JSONException e) {
            e.printStackTrace();
        }

        progressDialog.dismiss();

        // run UI components after data loads, ex. saveData = data.

    }
   
</code>
</pre>

<h4>Call on Activity</h4>
<pre>
<code>

 RestAPI runTask = new RestAPI(this);
 runTask.execute();
 
</code>
</pre>

<h2>Updates</h2>
<p>
    <i>
    *None.
    </i>
</p>

