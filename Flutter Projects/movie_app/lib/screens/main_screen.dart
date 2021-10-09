import 'package:flutter/material.dart';
import 'package:movie_app/screens/favorite_screen.dart';
import 'package:movie_app/screens/home_screen.dart';
import 'package:movie_app/screens/search_screen.dart';
import 'package:movie_app/screens/settings_screen.dart';

class MainScreen extends StatefulWidget {
  const MainScreen({Key? key}) : super(key: key);

  @override
  _MainScreenState createState() => _MainScreenState();
}

class _MainScreenState extends State<MainScreen> {
  int _currentIndex = 0;
  final List<Widget> _children = const [
    HomeScreen(),
    SearchScreen(),
    FavoriteScreen(),
    SettingsScreen()
  ];

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: _children[_currentIndex],
      bottomNavigationBar: BottomNavigationBar(
          backgroundColor: Theme.of(context).scaffoldBackgroundColor,
          type: BottomNavigationBarType.fixed,
          iconSize: 35,
          selectedFontSize: 22,
          unselectedFontSize: 17,
          unselectedItemColor: Colors.white,
          currentIndex: _currentIndex, //koji ce biti dole selektovan
          items: const [
            BottomNavigationBarItem(
              //activeIcon: CircleAvatar(child: Icon(Icons.home)),
              icon: Icon(Icons.home),
              label: "Home",
            ),
            BottomNavigationBarItem(
                icon: Icon(Icons.search),
                label: "Search",
                backgroundColor: Colors.blue),
            BottomNavigationBarItem(
                icon: Icon(Icons.favorite),
                label: "Favorite",
                backgroundColor: Colors.blue),
            BottomNavigationBarItem(
                icon: Icon(Icons.settings),
                label: "Settings",
                backgroundColor: Colors.blue),
          ],
          onTap: (index) {
            setState(() {
              _currentIndex = index;
            });
          }),
    );
  }
}
