using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Net;
using System.Text;
using System.IO;
using LocationScoutWebApp.LocationServicesRef;

namespace LocationScoutWebApp
{
    public partial class ElectiveTryItWebForm : System.Web.UI.Page
    {
 
        protected void ButtonStoreService_Click(object sender, EventArgs e)
        {
            string errorMessage = "Please enter valid input..!";
            String inputZipcode = TextBoxZipCode.Text;
            String inputStoreName = TextBoxStoreName.Text;

            if (inputZipcode.Equals("") && inputStoreName.Equals(""))
            {
                LabelStoreAddress.Text = errorMessage;
            }
            else
            {
                LocationServicesClient storeClient = new LocationServicesClient();
                String address = (String)storeClient.findNearestStore(inputZipcode, inputStoreName);
                LabelStoreAddress.Text = address;
            }
        }
        protected void ButtonZipService_Click(object sender, EventArgs e)
        {
            String errorMessage = "Please enter valid input..!";
            String inputZipCode = TextBoxZipCode2.Text;

            if (!inputZipCode.Equals(""))
            {
                LocationServicesClient locationClient = new LocationServicesClient();
                LabelLanLon.Text = locationClient.getLatLonByZipCode(inputZipCode);
            }
            else
            {
                LabelLanLon.Text = errorMessage;
            }
        }
    }
}