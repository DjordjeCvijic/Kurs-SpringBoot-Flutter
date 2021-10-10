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
          iconSize: 25,
          selectedFontSize: 10,
          unselectedFontSize: 8,
          unselectedItemColor: Colors.white,
          currentIndex: _currentIndex, //koji ce biti dole selektovan
          items: const [
            BottomNavigationBarItem(
                activeIcon: CircleAvatar(
                  child: Icon(
                    Icons.home,
                    size: 25,
                  ),
                  radius: 23,
                ),
                icon: Icon(Icons.home),
                label: ""),
            BottomNavigationBarItem(
                activeIcon: CircleAvatar(
                  child: Icon(
                    Icons.search,
                    size: 25,
                  ),
                  radius: 23,
                ),
                icon: Icon(Icons.search),
                label: ""),
            BottomNavigationBarItem(
                activeIcon: CircleAvatar(
                  child: Icon(
                    Icons.favorite,
                    size: 25,
                  ),
                  radius: 23,
                ),
                icon: Icon(Icons.favorite),
                label: ""),
            BottomNavigationBarItem(
                activeIcon: CircleAvatar(
                  child: Icon(
                    Icons.settings,
                    size: 25,
                  ),
                  radius: 23,
                ),
                icon: Icon(Icons.settings),
                label: ""),
          ],
          onTap: (index) {
            setState(() {
              _currentIndex = index;
            });
          }),
    );
  }
}
