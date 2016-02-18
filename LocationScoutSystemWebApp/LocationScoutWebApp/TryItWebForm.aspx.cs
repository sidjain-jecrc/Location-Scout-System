using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using LocationScoutWebApp.LocationServicesRef;

namespace LocationScoutWebApp
{
    public partial class TryItWebForm : System.Web.UI.Page
    {
        protected void ButtonSolarIntensity_Click(object sender, EventArgs e)
        {
            string errorMessage = "Please enter valid input..!";
            // If user has not entered any value then the label will notify the user
            if (TextBoxSolarLatitude.Text.Equals("") && TextBoxSolarLongitude.Text.Equals(""))
            {
                LabelSunshineIndex.Text = errorMessage;
            }
            else
            {
                decimal latitude = Convert.ToDecimal(TextBoxSolarLatitude.Text);
                decimal longitude = Convert.ToDecimal(TextBoxSolarLongitude.Text);

                // checking if the latitude and longitude entered are within the expected range
                if (latitude >= -90 && latitude < 90 && longitude >= -180 && longitude < 180)
                {
                    LocationServicesClient locationClient = new LocationServicesClient();
                    decimal solarIndex = (decimal)locationClient.getSolarIntensity(latitude, longitude);
                    LabelSunshineIndex.Text = Convert.ToString(solarIndex);
                }
                else
                {   // if not within range displaying message to user
                    LabelSunshineIndex.Text = errorMessage;
                }
            }
        }

        protected void ButtonWindIntensity_Click(object sender, EventArgs e)
        {
            string errorMessage = "Please enter valid input..!";
            // If user has not entered any value then the label will notify the user
            if (TextBoxWindLatitude.Text.Equals("") && TextBoxWindLongitude.Text.Equals(""))
            {
                LabelWindIndex.Text = errorMessage;
            }
            else
            {
                decimal latitude = Convert.ToDecimal(TextBoxWindLatitude.Text);
                decimal longitude = Convert.ToDecimal(TextBoxWindLongitude.Text);

                // checking if the latitude and longitude entered are within the expected range
                if (latitude >= -90 && latitude < 90 && longitude >= -180 && longitude < 180)
                {
                    LocationServicesClient locationClient = new LocationServicesClient();
                    decimal windIndex = (decimal)locationClient.getWindIntensity(latitude, longitude);
                    LabelWindIndex.Text = Convert.ToString(windIndex);
                }
                else
                {
                    // if not within range displaying message to user
                    LabelWindIndex.Text = errorMessage;
                }
            }
        }
    }
}