<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="ElectiveTryItWebForm.aspx.cs" Inherits="LocationScoutWebApp.ElectiveTryItWebForm" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Location Scout Try It App</title>
    <style type="text/css">
        .auto-style1 {
            font-size: large;
        }
    </style>
</head>
<body>
    <form id="form1" runat="server">
        <h3> This is an ASP.Net application to test find nearest store and zipcode to latitude, longitude conversion services</h3>
        <p class="auto-style1">
            <strong>Find the Nearest Store Service</strong></p>
        <p>
            <strong>Description:</strong> This service returns the address of the store name closest to the given zipcode
        </p>
        <p>
            <strong>Operation or Method Signature:</strong> String findNearestStore(String zipcode, String storeName)
        </p>
        <p>
            <strong>Input - Enter Zipcode:</strong>
            <asp:TextBox ID="TextBoxZipCode" runat="server" ></asp:TextBox>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong>Enter Store Name:</strong> &nbsp;<asp:TextBox ID="TextBoxStoreName" runat="server"></asp:TextBox>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <asp:Button ID="ButtonStoreService" runat="server" OnClick="ButtonStoreService_Click" Text="Invoke Service" />
&nbsp;&nbsp;&nbsp;
        </p>
        <p>
            Address of the Nearest Store (Output) :
            <asp:Label ID="LabelStoreAddress" runat="server" Font-Bold="True" ForeColor="Black" Text="addressOfStoreName" Font-Italic="True"></asp:Label>
        </p>
        <p>
            <strong style="font-size: large">Zipcode to Latitude Longitude Conversion Service</strong></p>
        <p>
            <strong>Description:</strong> This service returns the latitude, longitude pair for the given zipcode</p>
        <p>
            <strong>Operation or Method Signature:</strong> String getLatLonByZipCode(String zipcode)<strong> </strong>&nbsp;</p>
        <p>
            <strong>Input - Enter Zipcode: </strong>&nbsp;<asp:TextBox ID="TextBoxZipCode2" runat="server"></asp:TextBox>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <asp:Button ID="ButtonZipService" runat="server" OnClick="ButtonZipService_Click" Text="Invoke Service" />
        </p>
        <p>
            Latitude, Longitude (Output) :&nbsp; <asp:Label ID="LabelLanLon" runat="server" Font-Bold="True" Font-Italic="True" Text="latitudeLongitude"></asp:Label>
        </p>
        <p>
            <asp:HyperLink ID="HyperLink1" runat="server" NavigateUrl="http://webstrar14.fulton.asu.edu/page1/TryItWebForm.html" style="font-size: medium">Back To Required Services Try It Page</asp:HyperLink>
        </p>
    </form>
    <p class="auto-style1">
        &nbsp;</p>
</body>
</html>

