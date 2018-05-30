using NLPDotNetLib.NLP;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace NLPDotNet
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void checkBox1_CheckedChanged(object sender, EventArgs e)
        {
            CheckBox cb = (CheckBox)sender;
            if (cb.Checked)
                textBox1.Enabled = true;
            else
                textBox1.Enabled = false;
        }

        private void checkBox2_CheckedChanged(object sender, EventArgs e)
        {
            CheckBox cb = (CheckBox)sender;
            if (cb.Checked)
                textBox2.Enabled = true;
            else
                textBox2.Enabled = false;
        }

        private void checkBox3_CheckedChanged(object sender, EventArgs e)
        {
            CheckBox cb = (CheckBox)sender;
            if (cb.Checked)
                textBox3.Enabled = true;
            else
                textBox3.Enabled = false;
        }

        private void checkBox4_CheckedChanged(object sender, EventArgs e)
        {
            CheckBox cb = (CheckBox)sender;
            if (cb.Checked)
                textBox4.Enabled = true;
            else
                textBox4.Enabled = false;
        }

        private void checkBox5_CheckedChanged(object sender, EventArgs e)
        {
            CheckBox cb = (CheckBox)sender;
            if (cb.Checked)
                textBox5.Enabled = true;
            else
                textBox5.Enabled = false;
        }

        private void checkBox6_CheckedChanged(object sender, EventArgs e)
        {
            CheckBox cb = (CheckBox)sender;
            if (cb.Checked)
                textBox6.Enabled = true;
            else
                textBox6.Enabled = false;
        }

        private void Btn_Run_Click(object sender, EventArgs e)
        {
            RTB_Results.Text = "Running...Please hold on...";
            //check Patient ID
            if (TB_PatientID.Text.Equals(""))
            {
                RTB_Results.AppendText("Please input a Patient's ID first!\n");
                return;
            }
            //check is there any selectect item
            String hr = null;
            String sleep = null;
            String steps = null;
            String weight = null;
            String floor = null;
            String bmi = null;
            for(int i = 1; i <= 6; i++)
            {
                CheckBox cb = tableLayoutPanel3.Controls["checkBox" + i] as CheckBox;
                if(cb != null)
                {
                    if (i == 1 && !textBox1.Text.Equals("") && cb.Checked)
                        hr = textBox1.Text;
                    else if (i == 1 && textBox1.Text.Equals("") && cb.Checked)
                        RTB_Results.AppendText("\nPlease input your selected HR.");
                    if (i == 2 && !textBox2.Text.Equals("") && cb.Checked)
                        sleep = textBox2.Text;
                    else if (i == 2 && textBox2.Text.Equals("") && cb.Checked)
                        RTB_Results.AppendText("\nPlease input your selected Sleep.");
                    if (i == 3 && !textBox3.Text.Equals("") && cb.Checked)
                        steps = textBox3.Text;
                    else if (i == 3 && textBox3.Text.Equals("") && cb.Checked)
                        RTB_Results.AppendText("\nPlease input your selected Steps.");
                    if (i == 4 && !textBox4.Text.Equals("") && cb.Checked)
                        floor = textBox4.Text;
                    else if (i == 4 && textBox4.Text.Equals("") && cb.Checked)
                        RTB_Results.AppendText("\nPlease input your selected Floors.");
                    if (i == 5 && !textBox5.Text.Equals("") && cb.Checked)
                        weight = textBox5.Text;
                    else if (i == 5 && textBox5.Text.Equals("") && cb.Checked)
                        RTB_Results.AppendText("\nPlease input your selected Weight.");
                    if (i == 6 && !textBox6.Text.Equals("") && cb.Checked)
                        bmi = textBox6.Text;
                    else if (i == 6 && textBox6.Text.Equals("") && cb.Checked)
                        RTB_Results.AppendText("\nPlease input your selected BMI.");
                }
            }
            //check for illeagle
            if (hr == null && sleep == null && steps == null && weight == null && floor == null && bmi == null)
                return;
            //get all the triggered rule name
            NLPBusiness business = NLPBusiness.Business;
            List<String> triggeredRuleNames = business.GetTriggeredRuleName(bmi, hr, sleep, steps, floor, weight);
            RTB_Results.AppendText("\nGetting Data from database...");
            if (!business.GetPatientDate(TB_PatientID.Text
                    , bmi, hr, sleep, steps, floor, weight))
            {
                RTB_Results.Text = "The Patient does not have certain data of PatientID: " + TB_PatientID.Text;
                return;
            }
            else
            {
                RTB_Results.AppendText(business.GetPatientInfo());
            }
            //do all the triggered DRTules
            foreach(String ruleName in triggeredRuleNames)
            {
                RTB_Results.AppendText("\n\n" + ruleName + ":\n" + business.RunWithNewData(ruleName));
            }
        }
    }
}
