import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.work.ExistingWorkPolicy
import androidx.work.WorkManager
import io.flutter.embedding.engine.loader.FlutterLoader

class FlutterPluginBackgroundJobBroadcastReceiver: BroadcastReceiver() {
    companion object {
        private const val TAG = "BackgroundBroadcastReceiver";
    }
    override fun onReceive(context: Context, intent: Intent) {
        FlutterLoader().startInitialization(context)
        FlutterLoader().ensureInitializationComplete(context, null)
        val workManager = WorkManager.getInstance(context)

        val request = FlutterPluginBackgroundJobService.buildWorkRequest()
        workManager.enqueueUniqueWork(FlutterPluginBackgroundJobService.UNIQUE_WORK_NAME, ExistingWorkPolicy.KEEP, request)
    }

}