/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function ()
{
   $("#filtra").keyup(function()
    {  
        // Preleva il valore
        var text = $("#filtra").val();
       
        $.ajax(
        {
            url: "Filter",
            data:{
              cmd: "search",
              text: text
            },
            dataType: 'json',
            success : function(data, state){
                aggiornaListaOggetti(data);
            },
            error : function(data, state){
            }
        });
        
       // Funzione che viene richiamata in caso di successo
        function aggiornaListaOggetti(listaOggetti, idCliente)
        {
            // Cancella la lista
            $("#oggettistica").empty();
            // Per ogni alunno trovato dal database
            for(var oggetto in listaOggetti)
            {
                //creo il tag li
                var newli = document.createElement("li");
                newli.setAttribute("name", "oggetto");
                    //creo il tag div
                    var newDiv = document.createElement("div");
                    newDiv.setAttribute("class", "ogg_image");
                        //creo il tag img
                        var image = document.createElement("IMG");
                        image.setAttribute("src", listaOggetti[oggetto].urlImmagine, "width", "50", "height", "50");
                        //Eseguo il tag img
                        newDiv.appendChild(image);
                    //eseguo il div.
                    newli.appendChild(newDiv);
                    
                    //creo un nuovo div
                    var newDiv2 = document.createElement("div");
                    newDiv2.setAttribute("class", "ogg_desc");
                        //creo un campo testuale che stampi valori dell'oggetto.
                        var text = document.createTextNode(" "
                                + listaOggetti[oggetto].nome
                                + "\n" + listaOggetti[oggetto].descrizione
                                + "\nPrezzo per elemento=" + listaOggetti[oggetto].prezzo);
                        //stampo il textbox:
                        newDiv2.appendChild(text);
                        
                        // Crea link
                        var link = document.createElement("a");
                        link.setAttribute("href", "RiepilogoOrdine.jsp?idOggetto="
                                                    + listaOggetti[oggetto].id 
                                                    + "&nomeOggetto=" +listaOggetti[oggetto].nome
                                                    + "&descrizioneOgg=" +listaOggetti[oggetto].descrizione
                                                    + "&prezzoOgg=" +listaOggetti[oggetto].prezzo
                                                    + "&idCliente=" +idCliente , "name", "oggetto");
                            var LinkTxt = document.createTextNode("Aggiungi al carrello");
                            link.appendChild(LinkTxt);
                        newDiv2.appendChild(link);
                    //eseguo il div2.
                    newli.appendChild(newDiv2);
                
                // Aggiunge il tag li al tag ul "oggettistica"
                $("#oggettistica").append(newli);
            }
        }
    }); 
});