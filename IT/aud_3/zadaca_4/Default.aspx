<%@ Page Title="Home Page" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="Default.aspx.cs" Inherits="Primer._Default" %>

<asp:Content ID="BodyContent" ContentPlaceHolderID="MainContent" runat="server">
    <div class="container">
        <div class="row">
            <div class="col-md-12 text-center">
                Внесете име на валутата:
                </br>
                <asp:TextBox ID="ImeValuta" runat="server"></asp:TextBox>
            </div> 
            <div class="col-md-12 text-center">
                Внесете вредност на валутата:
                </br>
                <asp:TextBox ID="VrednostValuta" runat="server"></asp:TextBox>
            </div> 
            <div class="col-md-12 text-center">
                <asp:Button ID="Kopce" runat="server" Text="Додади валута" OnClick="Kopce_Click1" />
            </div>
            <div class="col-md-12 text-center">
                <asp:RadioButtonList ID="Valuti" runat="server"></asp:RadioButtonList>
            </div> 
            
        </div>
    </div>

</asp:Content>
