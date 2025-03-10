using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Lab1A
{
	public partial class Glasaj : System.Web.UI.Page
	{
		protected void Page_Load(object sender, EventArgs e)
		{

		}

        protected void glasajKopce_Click(object sender, EventArgs e)
        {
            Response.Redirect("UspeshnoGlasanje.aspx");
        }

        protected void lbPredmeti_SelectedIndexChanged(object sender, EventArgs e)
        {
            //AutoPostBack da e staveno na true kaj listata so predmeti
            lblProfesor.Text = "Проф. ";
            lblProfesor.Text += lbPredmeti.SelectedItem.Value;
        }
    }
}
