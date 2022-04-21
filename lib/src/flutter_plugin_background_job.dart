import 'dart:async';
import 'dart:ui';

import 'package:flutter/services.dart';
import 'package:flutter_plugin_background_job/src/callback_dispatcher.dart';

class FlutterPluginBackgroundJob {
  static const MethodChannel _channel = MethodChannel('flutter_plugin_background_job');

  static Future<String?> get platformVersion async {
    final String? version = await _channel.invokeMethod('getPlatformVersion');
    return version;
  }

  static Future<void> initialize() async {
    final CallbackHandle? callback = PluginUtilities.getCallbackHandle(callbackDispatcher);
    await _channel.invokeMethod('FlutterPluginBackgroundJobPlugin.initializeService', <dynamic>[callback!.toRawHandle()]);
  }

  static Future<void> registerPingMessage(void Function(String message) callback) async {
    final List<dynamic> args = <dynamic>[PluginUtilities.getCallbackHandle(callback)!.toRawHandle()];
    await _channel.invokeMethod('FlutterPluginBackgroundJobPlugin.registerPingMessage', args);
  }
}
