ResidenceSimpleClans
====================

This plugin is a bridge between [Residence](http://dev.bukkit.org/server-mods/residence/) and [SimpleClans](http://dev.bukkit.org/server-mods/simpleclans/).

It adds 4 new flags to any residence:

* clanbuild - to allow clanners to build on your land

* clanuse - to allow your clanmates to use stuff inside your house

* clanmove - to admit only members of your clan to your party (falls back to move flag!)

* clancontainer - to make a shared storage for your clan(?)

**INSTALLATION**

You have to edit your Residence's config.yml (it's in your plugins\Residence folder). You have to add all these flags to Global (default: true), FlagPermission (default: true) and ResidenceDefault (default: false) sections. After that just restart your server and go add some flags. No commands, no config, just that simple.

**REQUIREMENTS**

This plugin DOES REQUIRE both [Residence](http://dev.bukkit.org/server-mods/residence/) AND [SimpleClans](http://dev.bukkit.org/server-mods/simpleclans/). If you don't have one of this set - it not gonna work.

Bukkit version 1.1R1 is minimum required, but this plugin works on most recent build also without any problems.

**THANKS**

Thanks to authors of Residence, especially *bekvon*. Without his advise this plugin would never work as intended.