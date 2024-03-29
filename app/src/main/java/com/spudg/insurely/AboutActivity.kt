package com.spudg.insurely

import android.app.Dialog
import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_about.*
import kotlinx.android.synthetic.main.dialog_terms_of_use.*

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val version = packageManager.getPackageInfo(packageName, 0).versionName
        spudg_insurance_organiser_desc.text = getString(R.string.version_by_ss, version.toString())

        back_to_policies_from_about.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        privacy_policy.setOnClickListener {
            privacyPolicy()
        }

        terms_of_use.setOnClickListener {
            termsOfUse()
        }

        rate_btn.setOnClickListener {
            rate()
        }
    }

    private fun privacyPolicy() {
        val url =
                "https://docs.google.com/document/d/12x1U4WxVJPA8Gr0OA0qq-8ofetMnXdxoDLvqP80hU3g"
        val i = Intent(Intent.ACTION_VIEW)
        i.data = Uri.parse(url)
        startActivity(i)
    }

    private fun termsOfUse() {
        val termsOfUseDialog = Dialog(this, R.style.Theme_Dialog)
        termsOfUseDialog.setCancelable(false)
        termsOfUseDialog.setContentView(R.layout.dialog_terms_of_use)
        termsOfUseDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        termsOfUseDialog.tvDoneTU.setOnClickListener {
            termsOfUseDialog.dismiss()
        }

        termsOfUseDialog.show()

    }

    private fun rate() {
        val url =
                "https://play.google.com/store/apps/details?id=com.spudg.spudginsuranceorganiser"
        val i = Intent(Intent.ACTION_VIEW)
        i.data = Uri.parse(url)
        startActivity(i)
    }

}