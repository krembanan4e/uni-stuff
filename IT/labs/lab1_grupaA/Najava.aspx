<%@ Page Title="" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="Najava.aspx.cs" Inherits="Lab1A.Najava" %>

<asp:Content ID="Content1" ContentPlaceHolderID="MainContent" runat="server">
    <div class="container">
        <div class="row">
            <div class="col">
                <div>
                    <asp:Label ID="lbIme" runat="server" Text="Име" Width="100px"></asp:Label>
                    <asp:TextBox ID="ime" runat="server"></asp:TextBox>
                </div>
                <div>
                    <asp:Label ID="lbLozinka" runat="server" Text="Лозинка" Width="100px"></asp:Label>
                    <asp:TextBox ID="lozinka" runat="server"></asp:TextBox>
                </div>
                <div>
                    <asp:Label ID="lbAdresa" runat="server" Text="е-адреса" Width="100px"></asp:Label>
                    <asp:TextBox ID="adresa" runat="server"></asp:TextBox>
                </div>
                <asp:Button ID="najavaKopce" runat="server" Text="Најавете се" OnClick="najavaKopce_Click" />
            </div>
        </div>
    </div>
</asp:Content>
