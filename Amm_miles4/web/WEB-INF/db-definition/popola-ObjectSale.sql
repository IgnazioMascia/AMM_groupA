/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Ignazio
 * Created: 26-lug-2016
 */

INSERT INTO ObjectSale  (id, nome, descrizione, num_pezzi, prezzo, categoria, urlImmagine, idVendita)
VALUES                  (default,   'Ciondolo dei doni della morte',
                                    'Gadget tratto dalla saga di Harry Potter,
                                        é il simbolo di Grindelwald, indossato come
                                        ciondolo da uno dei personaggi.',
                                    1, 5.60, 'gadget', 'images/Ciondolo.jpeg',
                                    1),
                        (default,   'Abito elegante uomo',
                                    'Abito elegante di Valentino, tg.42, collezione
                                        primavera 2012. Colore: grigio. 
                                        (Scarpe e camicia non inclusi).',
                                    3, 670.23, 'vestiario', 'images/AbitoUomo.jpg',
                                    1),
                        (default,   'Cellulare Nokia Lumia',
                                    'Smartphone Nokia Lumia 535. Può fare tante cose!
                                        Persino il café, Wow!',
                                    27, 119.99, 'telefonia', 'images/Cellulare.jpg',
                                    2),
                        (default,   'Tenda da sole Tempotest',
                                    'Tenda da sole per Balconi, modello UglySole, con
                                        bracci estensibili. Colore: Azzurro
                                        e bianco. Misure: 295x200cm.',
                                    0, 221.99, 'arredamento', 'images/TendeDaSole.jpg',
                                    2),
                        (default,   'Tiragraffi per gatti',
                                    'Tiragraffi per gatti, modello Miao dell^ azienda
                                        Gatoh&Co. Differenti colori disponibili.
                                        Misure: 120x50x36mm.',
                                    100, 35.00, 'gocattoli', 'images/Tiragraffi.jpg',
                                    3);