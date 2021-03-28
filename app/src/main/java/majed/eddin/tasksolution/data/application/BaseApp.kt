package majed.eddin.tasksolution.data.application

import android.app.Application
import majed.eddin.tasksolution.BuildConfig
import majed.eddin.tasksolution.data.consts.AppConst

class BaseApp : Application() {

    private lateinit var appConst: AppConst

    companion object {
        var instance: BaseApp = BaseApp()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        appConst = AppConst.instance
        initAppConst()
    }


    private fun initAppConst() {
        appConst.appInstance = this
        appConst.isDebug = BuildConfig.DEBUG
        appConst.appBaseUrl = BuildConfig.BASE_URL
    }

}