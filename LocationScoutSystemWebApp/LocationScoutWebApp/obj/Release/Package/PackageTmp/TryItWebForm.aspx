<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="TryItWebForm.aspx.cs" Inherits="LocationScoutWebApp.TryItWebForm" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Location Scout System Try It</title>
</head>
<body>
    <form id="form1" runat="server">
        <asp:Label ID="LabelHeader" runat="server" Font-Bold="True" Font-Size="Larger" Text="This is an ASP.Net Application to Test Solar Energy and Wind Energy Services"></asp:Label>
        <p>
            <asp:Label ID="LabelSolarEnergy" runat="server" Font-Bold="True" Font-Size="Medium" Text="Solar Energy Service" style="font-size: large"></asp:Label>
        </p>
        <p>
            <strong>Description: </strong> Solar energy service returns the annual average sunshine index of a given position (latitude, longitude)</p>
        <p>
            <strong>Operation or Method Signature:</strong> decimal getSolarIntensity(decimal latitude, decimal longitude)</p>
        <p>
            <strong>Enter Latitude (-90 to +89) :</strong>
            <asp:TextBox ID="TextBoxSolarLatitude" runat="server"></asp:TextBox>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong>Enter Longitude (-180 to +179) :</strong>
            <asp:TextBox ID="TextBoxSolarLongitude" runat="server"></asp:TextBox>
&nbsp;&nbsp;&nbsp;&nbsp;
            <asp:Button ID="ButtonSolarIntensity" runat="server" OnClick="ButtonSolarIntensity_Click" Text="Get Solar Intensity" Width="169px" />
&nbsp;&nbsp;
        </p>
        <p>
            Annual Average Sunshine Index (Output):
            <asp:Label ID="LabelSunshineIndex" runat="server" Font-Bold="True" Text="sunshineIndex"></asp:Label>
        </p>
        <p>
            &nbsp;</p>
        <p>
            <asp:Label ID="LabelWindEnergy" runat="server" Font-Bold="True" Font-Size="Medium" Text="Wind Energy Service" style="font-size: large"></asp:Label>
        </p>
        <p>
            <strong>Description: </strong> Wind energy service returns the annual average wind index of a given position (latitude, longitude)</p>
        <p>
            <strong>Operation or Method Signature:</strong> decimal getWindIntensity(decimal latitude, decimal longitude)</p>
        <p>
            <strong>Enter Latitude (-90 to +89) </strong>:
            <asp:TextBox ID="TextBoxWindLatitude" runat="server"></asp:TextBox>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong>Enter Longitude (-180 to +179) : </strong>
            <asp:TextBox ID="TextBoxWindLongitude" runat="server"></asp:TextBox>
&nbsp;&nbsp;&nbsp;&nbsp;
            <asp:Button ID="ButtonWindIntensity" runat="server" OnClick="ButtonWindIntensity_Click" Text="Get Wind Intensity" Width="169px" />
        </p>
        <p>
            Annual Average Wind Index (Output):
            <asp:Label ID="LabelWindIndex" runat="server" Font-Bold="True" Text="windIndex"></asp:Label>
        </p>
        <p>
            <asp:HyperLink ID="HyperLink1" runat="server" NavigateUrl="http://webstrar14.fulton.asu.edu/page1/ElectiveTryItWebForm.html" style="font-size: medium">Go To Elective Services TryIt Page</asp:HyperLink>
        </p>
    </form>
    <p>
        &nbsp;</p>
</body>
</html>