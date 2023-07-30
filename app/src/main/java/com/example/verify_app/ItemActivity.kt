package com.example.verify_app

import android.app.Activity
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.razorpay.Checkout
import com.razorpay.ExternalWalletListener
import com.razorpay.PaymentData
import com.razorpay.PaymentResultWithDataListener
import org.json.JSONObject
import com.razorpay.PaymentResultListener


class ItemActivity : AppCompatActivity(), PaymentResultWithDataListener, ExternalWalletListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)

        Checkout.preload(applicationContext)
        val co = Checkout()
        // apart from setting it in AndroidManifest.xml, keyId can also be set
        // programmatically during runtime
        co.setKeyID("rzp_live_XXXXXXXXXXXXXX")

        val title = findViewById<TextView>(R.id.item_title)
        val desc = findViewById<TextView>(R.id.item_desc)
        val image = findViewById<ImageView>(R.id.item_image)
        val btnBuy  =findViewById<Button>(R.id.item_button)

        title.text = intent.getStringExtra("itemTitle")
        desc.text = intent.getStringExtra("itemDesc")
        image.setImageResource(intent.getStringExtra("itemImage")!!.toInt())
        btnBuy.setOnClickListener{
            startPayment()
        }
    }

    private fun startPayment() {

        val activity: Activity = this
        val co = Checkout()

        try {
            val options = JSONObject()
            options.put("name","Oleksandr UA")
            options.put("description","Demoing Charges")
            //You can omit the image option to fetch the image from the dashboard
            options.put("image","https://s3.amazonaws.com/rzp-mobile/images/rzp.jpg")
            options.put("theme.color", "#3399cc");
            options.put("currency","USD");
            options.put("order_id", "order_DBJOWzybf0sJbb");
            options.put("amount",100)//pass amount in currency subunits
//
//            val prefill = JSONObject()
//            prefill.put("email","gaurav.kumar@example.com")
//            prefill.put("contact","9876543210")

//            options.put("prefill",prefill)
            co.open(activity,options)
        }catch (e: Exception){
            Toast.makeText(activity,"Error in payment: "+ e.message,Toast.LENGTH_LONG).show()
            e.printStackTrace()
        }
    }

    override fun onPaymentSuccess(p0: String?, p1: PaymentData?) {
        Toast.makeText(this,"Payment success.",Toast.LENGTH_LONG).show()
    }

    override fun onPaymentError(p0: Int, p1: String?, p2: PaymentData?) {
        Toast.makeText(this,"Error in payment.",Toast.LENGTH_LONG).show()
    }

    override fun onExternalWalletSelected(p0: String?, p1: PaymentData?) {
        Toast.makeText(this,"Extarnal wallet selected",Toast.LENGTH_LONG).show()
    }
}

class PaymentActivity: Activity(), PaymentResultListener {
    // ...
    override fun onPaymentError(errorCode: Int, response: String?) {
        Toast.makeText(Activity(),"Error payment",Toast.LENGTH_LONG).show()
    }

    override fun onPaymentSuccess(razorpayPaymentId: String?) {
        Toast.makeText(Activity(),"Payment success.",Toast.LENGTH_LONG).show()
    }
}
