/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Ignazio
 * Created: 26-lug-2016
 */

CREATE TABLE Carrello_Oggetto
(
    idCliente INTEGER,
    FOREIGN KEY (idCliente) REFERENCES Cliente(id),
    idOggetto INTEGER,
    FOREIGN KEY (idOggetto) REFERENCES ObjectSale(id)

);