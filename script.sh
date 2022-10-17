#!/bin/bash

print_man()
{
    cat << USAGE
DESCRIPTION :
    -r --remove
        permet de supprimer l'application
    -i --install 
        permet d'installer l'application
    *
        permet d'afficher le manuel
USAGE
}

install()
{
    sudo docker build -t pablex/pablex_api .
    sudo docker-compose up -d
    echo "L'installation de pablex est terminée !"
}

uninstall()
{
    sudo docker container stop pablex_api pablex_mysql
    sudo docker container rm pablex_api pablex_mysql
    sudo docker volume rm pablex_mysql_conf pablex_mysql_data
    sudo docker image rm pablex/pablex_api openjdk:8-jdk-alpine mysql
    sudo docker network rm pablex_network
    echo "L'application pablex est désinstallée !"
}

main()
{
    if [ $# -eq 0 ]
    then
        echo "ALERTE : Il faut au minimum un paramètre !"
        print_man 
        exit 1;
    fi
    case $1 in
        --remove|-r)
            uninstall ;;
        --install|-i)
            install ;;
        *)
            print_man ;;
    esac
}

main "$@"