package de.markusfisch.android.libra.activity

import de.markusfisch.android.libra.app.setFragment
import de.markusfisch.android.libra.fragment.IssuesFragment
import de.markusfisch.android.libra.R

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import kotlinx.android.synthetic.main.toolbar.toolbar

class MainActivity() : AppCompatActivity() {
	override fun onSupportNavigateUp(): Boolean {
		val fm = supportFragmentManager
		if (fm.backStackEntryCount > 0) {
			fm.popBackStack()
		} else {
			finish()
		}
		return true
	}

	override fun onCreate(state: Bundle?) {
		super.onCreate(state)
		setContentView(R.layout.activity_main)
		initToolbar()

		if (state == null) {
			setFragment(supportFragmentManager, IssuesFragment())
		}
	}

	private fun initToolbar() {
		setSupportActionBar(toolbar)
		supportFragmentManager.addOnBackStackChangedListener {
			updateUpArrow()
		}
		updateUpArrow()
	}

	private fun updateUpArrow() {
		supportActionBar?.setDisplayHomeAsUpEnabled(
			supportFragmentManager.backStackEntryCount > 0
		)
	}
}
