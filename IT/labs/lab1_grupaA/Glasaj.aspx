<%@ Page Title="" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="Glasaj.aspx.cs" Inherits="Lab1A.Glasaj" %>
<asp:Content ID="Content1" ContentPlaceHolderID="MainContent" runat="server">
    <div class="container">
        <div class="row">
            <div class="col">
                <asp:Label ID="lblProfesor" runat="server" Text="Проф.">Проф. </asp:Label>
                <div>
                    <asp:ListBox ID="lbPredmeti" runat="server" AutoPostBack="True" OnSelectedIndexChanged="lbPredmeti_SelectedIndexChanged">
                        <asp:ListItem Value="Гоце Арменски">Интернет технологии</asp:ListItem>
                        <asp:ListItem Value="Костадин Мишев">Оперативни системи</asp:ListItem>
                        <asp:ListItem Value="Дејан Ѓорѓевиќ">Софтверско инженерство</asp:ListItem>
                    </asp:ListBox>
                    <asp:ListBox ID="lbKrediti" runat="server">
                        <asp:ListItem Value="6">6</asp:ListItem>
                        <asp:ListItem Value="6.5">6.5</asp:ListItem>
                        <asp:ListItem Value="5.5">5.5</asp:ListItem>
                    </asp:ListBox>
                </div>
                <asp:Button ID="glasajKopce" runat="server" Text="Гласајте" OnClick="glasajKopce_Click" />
            </div>
        </div>
    </div>
</asp:Content>
