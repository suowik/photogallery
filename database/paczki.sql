proponuje zrobic 3 paczki:
-users_management
-albums_management
-photos_management

users_management:
	-p register throws EXCEPTION
	-f login(email, pass) throws EXCEPTION
	-p remove(email)
	-f cursor findUserAlbums(email, number count, number offset)

albums_management:
	-p add
	-p remove(name)
	-f cursor findPhotos(name, number count, number offset)

photos_management:
	-p add
	-p remove(name)
	
	