<%@ Page Title="Home Page" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="Default.aspx.cs" Inherits="Primer._Default" %>

<asp:Content ID="BodyContent" ContentPlaceHolderID="MainContent" runat="server">
    <div class="container">
        <div class="row">
            <div class="col-md-12 text-center">
                <asp:ListBox ID="Gradovi" runat="server">
                    <asp:ListItem Value="sk">Skopje</asp:ListItem>
                    <asp:ListItem Value="ve">Veles</asp:ListItem>
                    <asp:ListItem Value="oh">Ohrid</asp:ListItem>
                </asp:ListBox>
            </div> 
            <div class="col-md-12 text-center">
                <asp:Button ID="Kopce" runat="server" Text="Прикажи град" OnClick="Kopce_Click" />
            </div> 
            <div class="col-md-12 text-center">
                <asp:Label ID="Prikaz" runat="server" Text="Нема избран град"></asp:Label>
            </div>
        </div>
    </div>

</asp:Content>
