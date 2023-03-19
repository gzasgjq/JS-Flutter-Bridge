import 'package:flutter/material.dart';

class SimplePage extends StatefulWidget {
  const SimplePage({super.key, required this.data});

  final Map<String, dynamic>? data;

  @override
  State<StatefulWidget> createState() => _SimplePageState(data);
}

class _SimplePageState extends State<SimplePage> {
  _SimplePageState(data);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          // Here we take the value from the MyHomePage object that was created by
          // the App.build method, and use it to set our appbar title.
          title: const Text('SimplePage'),
        ),
        body: Center(
            child: Column(
                // Column is also a layout widget. It takes a list of children and
                // arranges them vertically. By default, it sizes itself to fit its
                // children horizontally, and tries to be as tall as its parent.
                //
                // Invoke "debug painting" (press "p" in the console, choose the
                // "Toggle Debug Paint" action from the Flutter Inspector in Android
                // Studio, or the "Toggle Debug Paint" command in Visual Studio Code)
                // to see the wireframe for each widget.
                //
                // Column has various properties to control how it sizes itself and
                // how it positions its children. Here we use mainAxisAlignment to
                // center the children vertically; the main axis here is the vertical
                // axis because Columns are vertical (the cross axis would be
                // horizontal).
                mainAxisAlignment: MainAxisAlignment.center,
                children: <Widget>[
              const Text(
                'You have pushed the button this many times:',
              ),
              Text(
                "SSS",
                style: Theme.of(context).textTheme.headlineMedium,
              ),
            ])));
  }
}
