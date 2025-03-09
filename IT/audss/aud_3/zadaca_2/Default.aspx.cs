using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Primer
{
    public partial class _Default : Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void Kopce_Click(object sender, EventArgs e)
        {
            if (Gradovi.SelectedIndex == -1)
            {
                Prikaz.Text = "Нема избран град";
                return;
            }
            else
            {
                Prikaz.Text = Gradovi.SelectedItem.Text;
                Rastojanie.Text = Gradovi.SelectedItem.Value + "km";
            }
        }
    }
}
