package code.name.monkey.retromusic.activities

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import code.name.monkey.appthemehelper.ThemeStore
import code.name.monkey.appthemehelper.util.MaterialUtil
import code.name.monkey.retromusic.R
import code.name.monkey.retromusic.activities.base.AbsBaseActivity
import code.name.monkey.retromusic.extensions.applyToolbar
import kotlinx.android.synthetic.main.activity_pro_version.*


class PurchaseActivity : AbsBaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pro_version)
        setDrawUnderStatusBar()

        setStatusbarColorAuto()
        setNavigationBarColorPrimary()
        setTaskDescriptionColorAuto()
        setLightNavigationBar(true)

        val primaryColor = ThemeStore.primaryColor(this)
        toolbar.setBackgroundColor(primaryColor)
        appBarLayout.setBackgroundColor(primaryColor)

        applyToolbar(toolbar)

        restoreButton.isEnabled = false
        purchaseButton.isEnabled = false

        MaterialUtil.setTint(restoreButton, false)
        MaterialUtil.setTint(purchaseButton, true)
    }


    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        private const val TAG: String = "PurchaseActivity"
    }
}
