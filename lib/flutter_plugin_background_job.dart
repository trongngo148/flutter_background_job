
import 'dart:async';

import 'package:flutter/services.dart';

class FlutterPluginBackgroundJob {
  static const MethodChannel _channel = MethodChannel('flutter_plugin_background_job');

  static Future<String?> get platformVersion async {
    final String? version = await _channel.invokeMethod('getPlatformVersion');
    return version;
  }
}
