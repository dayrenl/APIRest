package ar.com.ada.api.spookify.controllers;

import java.util.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.spookify.entities.Album;

/**
 * AlbumController
 */
@RestController
public class AlbumController {

    @GetMapping (value = "/albumes")
    public List<Album> GetAlbum() {

        List<Album> albumes = new  ArrayList<Album>();
        
        Album a = new Album();
        a.setAnio(1997);
        a.setArtista("Satan");
        a.setCantidadCanciones(10);

        albumes.add(a);

        a = new Album();
        a.setAnio(2003);
        a.setArtista("Billie Eilish");
        a.setCantidadCanciones(13);
    
        albumes.add(a);

        a = new Album();
        a.setAnio(2005);
        a.setArtista("Chayanne");
        a.setCantidadCanciones(12);
    
        albumes.add(a);

        return albumes;

    }

    @GetMapping (value = "/album/1")
    public Album getPrimerAlbum() {
        return GetAlbum().get(0);
    }

    @GetMapping (value = "/album/2")
    public Album getSegundoAlbum() {
        return GetAlbum().get(1);
    }

    @GetMapping (value = "/album/3")
    public Album getTercerAlbum() {
        return GetAlbum().get(2);
    }



}