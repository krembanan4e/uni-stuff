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
            Prikaz.Text = "";
            Rastojanie.Text = "";

            if (Gradovi.SelectedIndex == -1)
            {
                Prikaz.Text = "Нема избран град";
                return;
            }

            else
            {
                ListItemCollection items = Gradovi.Items;
                foreach (ListItem item in items)
                {
                    if (item.Selected)
                    {
                        Prikaz.Text += "</br>" + item.Text;
                        Rastojanie.Text += "</br>" + item.Value;
                    }    
                }
            }
        }
    }
}
