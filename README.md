# Logiciel de dessin

#Commandes de créations

cercle1=cercle(1,(2,5),7)
Cela crée un cercle avec de la rayonne de 7 et un centre (2,5) et 1 comme id du groupe
carre1 = carre(1,(2,5),8)
Cela crée un carré avec cote de 8 et point du reference pour créer le carre (2,5)
tr1 = triangle((1,1),(0,0),(4,4))
Cela crée un triangle avec 3 points (1,1), (0,0), (4,4).
rec = rectangle(1,(4,4),7,18)
Cela crée un rectangle avec lon:7, lar:18 ,1 comme id du groupe, (4,4) comme ponit de reference pour créer le rectangle .

#Commandes de mouvement:

Tapez move  pour déplacer une forme. Par exemple: move(cercle1,(1,2))
Pour déplacer plusieurs formes à la fois, tapez movegroupe(1) ou 1 comme id groupe qui contient des formes pour les deplacer .

#Commandes d'affichage:

affichier(cercle) pour afficher la forme qui porte le nom cercle1.
affichergroupe(groupe1) pour afficher les formes du groupe avec id 1 .

#Commandes Enregistrer / Charger:

Tapez save nom du groupe  pour enregistrer le dessin.
save(groupe1)
Taper load(1) pour charger les formes du groupe d'id 1 qui existe sur la base de données
load(1)

#Commandes de suppression dans la base de données:

Tapez delete forme pour supprimer une forme. Par exemple:
delete(cercle1)
