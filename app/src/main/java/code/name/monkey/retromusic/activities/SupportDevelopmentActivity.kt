package code.name.monkey.retromusic.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import code.name.monkey.appthemehelper.ThemeStore
import code.name.monkey.appthemehelper.util.ATHUtil
import code.name.monkey.appthemehelper.util.MaterialUtil
import code.name.monkey.appthemehelper.util.TintHelper
import code.name.monkey.appthemehelper.util.ToolbarContentTintHelper
import code.name.monkey.retromusic.BuildConfig
import code.name.monkey.retromusic.R
import code.name.monkey.retromusic.activities.base.AbsBaseActivity
import code.name.monkey.retromusic.dialogs.UpiPaymentBottomSheetDialogFragment
import code.name.monkey.retromusic.extensions.textColorPrimary
import code.name.monkey.retromusic.extensions.textColorSecondary
import kotlinx.android.synthetic.main.activity_about.toolbar
import kotlinx.android.synthetic.main.activity_donation.*

class SupportDevelopmentActivity : AbsBaseActivity() {

    companion object {
        val TAG: String = SupportDevelopmentActivity::class.java.simpleName
        const val DONATION_PRODUCT_IDS = R.array.donation_ids
        private const val TEZ_REQUEST_CODE = 123
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    fun donate(i: Int) {
        val ids = resources.getStringArray(DONATION_PRODUCT_IDS)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_donation)

        setStatusbarColorAuto()
        setNavigationbarColorAuto()
        setTaskDescriptionColorAuto()
        setLightNavigationBar(true)

        setupToolbar()

        TintHelper.setTint(progress, ThemeStore.accentColor(this))
        donation.setTextColor(ThemeStore.accentColor(this))

        MaterialUtil.setTint(upiClick)
        upiClick.setOnClickListener {
            UpiPaymentBottomSheetDialogFragment().show(
                supportFragmentManager,
                UpiPaymentBottomSheetDialogFragment.TAG
            )
        }
    }

    private fun setupToolbar() {
        val toolbarColor = ATHUtil.resolveColor(this, R.attr.colorSurface)
        toolbar.setBackgroundColor(toolbarColor)
        ToolbarContentTintHelper.colorBackButton(toolbar)
        setSupportActionBar(toolbar)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == TEZ_REQUEST_CODE) {
            // Process based on the data in response.
            Log.d("result", data!!.getStringExtra("Status"))
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
