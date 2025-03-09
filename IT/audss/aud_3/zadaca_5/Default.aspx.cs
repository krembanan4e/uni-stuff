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

        protected void KopceDodadi_Click(object sender, EventArgs e)
        {
            Valuti.Items.Add(ImeValuta.Text);
            BrojNaStavki();
        }

        protected void KopceBrisi_Click(object sender, EventArgs e)
        {
            if (Valuti.SelectedIndex != -1)
            {
                Valuti.Items.Remove(Valuti.SelectedItem.Text);
                BrojNaStavki();
            }
        }

        private void BrojNaStavki()
        {
            Brojac.Text = Valuti.Items.Count.ToString();
        }

    }
}
