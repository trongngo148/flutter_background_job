import android.content.Context
import android.content.Intent
import androidx.work.*
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.PluginRegistry
import java.util.*
import java.util.concurrent.atomic.AtomicBoolean
import kotlin.collections.ArrayDeque

class FlutterPluginBackgroundJobService(context: Context, workerParameters: WorkerParameters): MethodChannel.MethodCallHandler, Worker(context, workerParameters) {
    private val queue = ArrayDeque<List<Any>>()
    private lateinit var mBackgroundChannel: MethodChannel
    private lateinit var mContext: Context

    companion object {
        @JvmStatic
        public val UNIQUE_WORK_NAME = "BackgroundWork"
        @JvmStatic
        private val TAG = "BackgroundJobService"
        @JvmStatic
        private val JOB_ID = UUID.randomUUID().mostSignificantBits.toInt()
        @JvmStatic
        private val sBackgroundFlutterEngine: FlutterEngine? = null
        @JvmStatic
        private val sServiceStarted = AtomicBoolean(false)
        @JvmStatic
        fun buildWorkRequest(): OneTimeWorkRequest {
            return OneTimeWorkRequestBuilder<FlutterPluginBackgroundJobService>().apply { }.build()
        }
    }
    /**
     * Handles the specified method call received from Flutter.
     *
     *
     * Handler implementations must submit a result for all incoming calls, by making a single
     * call on the given [Result] callback. Failure to do so will result in lingering Flutter
     * result handlers. The result may be submitted asynchronously and on any thread. Calls to
     * unknown or unimplemented methods should be handled using [Result.notImplemented].
     *
     *
     * Any uncaught exception thrown by this method will be caught by the channel implementation
     * and logged, and an error result will be sent back to Flutter.
     *
     *
     * The handler is called on the platform thread (Android main thread). For more details see
     * [Threading in
 * the Flutter Engine](https://github.com/flutter/engine/wiki/Threading-in-the-Flutter-Engine).
     *
     * @param call A [MethodCall].
     * @param result A [Result] used for submitting the result of the call.
     */
    override fun onMethodCall(call: MethodCall, result: MethodChannel.Result) {
        TODO("Not yet implemented")
    }

    /**
     * Override this method to do your actual background processing.  This method is called on a
     * background thread - you are required to **synchronously** do your work and return the
     * [androidx.work.ListenableWorker.Result] from this method.  Once you return from this
     * method, the Worker is considered to have finished what its doing and will be destroyed.  If
     * you need to do your work asynchronously on a thread of your own choice, see
     * [ListenableWorker].
     *
     *
     * A Worker has a well defined
     * [execution window](https://d.android.com/reference/android/app/job/JobScheduler)
     * to finish its execution and return a [androidx.work.ListenableWorker.Result].  After
     * this time has expired, the Worker will be signalled to stop.
     *
     * @return The [androidx.work.ListenableWorker.Result] of the computation; note that
     * dependent work will not execute if you use
     * [androidx.work.ListenableWorker.Result.failure] or
     * [androidx.work.ListenableWorker.Result.failure]
     */
    override fun doWork(): Result {
        TODO("Not yet implemented")
    }

}