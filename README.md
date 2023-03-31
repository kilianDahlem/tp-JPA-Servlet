# Template de projet pour le TP JPA 2021 UniR
# Projet réalisé par :

HOURMAND Rémi / remi.hourmand@etudiant.univ-rennes1.fr
DAHLEM Kilian / kilian.dahlem@etudiant.univ-rennes1.fr

Sur ce repos, vous trouverez :

le tp JPA ainsi que la partie Servlet du TP5.

La partie Reslet / JaxRS / OpenAPI ce trouve sur un autre repos.
Le repos en question : https://github.com/kilianDahlem/JaxRSOpenAPI

# PARTIE JPA

Lancer la classe JpaTest.

Vous verrez dans la console que les requêtes sont éxécutés.

Lorsque la partie Servlet sera lancé, vous pourrez accéder aux informations de la base de données en vous rendant sur le lien suivant :
http://localhost:8080/Home

# PARTIE SERVLET

Pour lancer le servlet, il faut éxécuter la commande maven suivante :
mvn compile jetty:run

Une fois que cette commande est éxécutée, vous pouvez vous rendre à l'URL suivante :
http://localhost:8080/Home

Une fois sur cette page, vous pouvez ajouter un User à la base de données en entrant le nom de celui-ci dans la première zone de texte.
Une fois la création de cet User effectué, vous arriverez sur la page : http://localhost:8080/CreateUsersFromDB

Retournez ensuite sur la page Home, vous verrez que le nouvel utilisateur apparaît dans la liste présent sur la page.

NB : Les autres éléments de ce formulaire n'ont pas pu être implémentés.

# Informations complémentaires

Ce repos ne contient qu'un unique commit car nous avons ré-organisé notre GIT.
