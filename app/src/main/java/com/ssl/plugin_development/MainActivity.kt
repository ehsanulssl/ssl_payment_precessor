package com.ssl.plugin_development

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.sslwireless.sslcommerzlibrary.model.initializer.SSLCommerzInitialization
import com.sslwireless.sslcommerzlibrary.model.response.SSLCTransactionInfoModel
import com.sslwireless.sslcommerzlibrary.model.util.SSLCCurrencyType
import com.sslwireless.sslcommerzlibrary.model.util.SSLCSdkType
import com.sslwireless.sslcommerzlibrary.view.singleton.IntegrateSSLCommerz
import com.sslwireless.sslcommerzlibrary.viewmodel.listener.SSLCTransactionResponseListener

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.payNowButton).setOnClickListener {
            val sslCommerzInitialization = SSLCommerzInitialization(
                "testbox",
                "qwerty",
                100.0,
                SSLCCurrencyType.BDT,
                "123456789098765",
                "yourProductType",
                SSLCSdkType.TESTBOX
            )
            IntegrateSSLCommerz
                .getInstance(this@MainActivity)
                .addSSLCommerzInitialization(sslCommerzInitialization)
                .buildApiCall(object : SSLCTransactionResponseListener{
                    override fun transactionSuccess(p0: SSLCTransactionInfoModel?) {}
                    override fun transactionFail(p0: String?) {}
                    override fun closed(p0: String?) {}
                })
        }
    }
}