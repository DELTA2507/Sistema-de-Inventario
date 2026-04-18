public class MapaCantones {
    public static Grafo crearGrafo() {

        Grafo grafo = new Grafo();

        String[] cantones = {
                "San José", "Escazú", "Desamparados", "Puriscal", "Tarrazú", "Aserrí", "Mora", "Goicoechea",
                "Santa Ana", "Alajuelita", "Vázquez de Coronado", "Acosta", "Tibás", "Moravia", "Montes de Oca",
                "Turrubares", "Dota", "Curridabat", "Pérez Zeledón", "León Cortés",

                "Alajuela", "San Ramón", "Grecia", "San Mateo", "Atenas", "Naranjo", "Palmares", "Poás",
                "Orotina", "San Carlos", "Zarcero", "Valverde Vega", "Upala", "Los Chiles", "Guatuso",
                "Río Cuarto",

                "Cartago", "Paraíso", "La Unión", "Jiménez", "Turrialba", "Alvarado", "Oreamuno", "El Guarco",

                "Heredia", "Barva", "Santo Domingo", "Santa Bárbara", "San Rafael", "San Isidro",
                "Belén", "Flores", "San Pablo", "Sarapiquí",

                "Liberia", "Nicoya", "Santa Cruz", "Bagaces", "Carrillo", "Cañas", "Abangares",
                "Tilarán", "Nandayure", "La Cruz", "Hojancha", "Monteverde",

                "Puntarenas", "Esparza", "Buenos Aires", "Montes de Oro", "Osa", "Quepos",
                "Golfito", "Coto Brus", "Parrita", "Corredores", "Garabito", "Puerto Jiménez",

                "Limón", "Pococí", "Siquirres", "Talamanca", "Matina", "Guácimo"
        };

        for (String canton : cantones) {
            grafo.agregarVertice(canton);
        }

        // Unir los cantones de San José con el cantón central
        grafo.agregarArista("San José", "Escazú", 9);
        grafo.agregarArista("San José", "Desamparados", 7);
        grafo.agregarArista("San José", "Puriscal", 35);
        grafo.agregarArista("San José", "Tarrazú", 70);
        grafo.agregarArista("San José", "Aserrí", 16);
        grafo.agregarArista("San José", "Mora", 18);
        grafo.agregarArista("San José", "Goicoechea", 8);
        grafo.agregarArista("San José", "Santa Ana", 15);
        grafo.agregarArista("San José", "Alajuelita", 7);
        grafo.agregarArista("San José", "Vázquez de Coronado", 11);
        grafo.agregarArista("San José", "Acosta", 28);
        grafo.agregarArista("San José", "Tibás", 6);
        grafo.agregarArista("San José", "Moravia", 7);
        grafo.agregarArista("San José", "Montes de Oca", 6);
        grafo.agregarArista("San José", "Turrubares", 65);
        grafo.agregarArista("San José", "Dota", 90);
        grafo.agregarArista("San José", "Curridabat", 8);
        grafo.agregarArista("San José", "Pérez Zeledón", 137);
        grafo.agregarArista("San José", "León Cortés", 75);

        // Interconectar los cantones centrales provinciales entre si
        grafo.agregarArista("San José", "San José", 0);
        grafo.agregarArista("San José", "Alajuela", 20);
        grafo.agregarArista("San José", "Cartago", 25);
        grafo.agregarArista("San José", "Heredia", 11);
        grafo.agregarArista("San José", "Liberia", 215);
        grafo.agregarArista("San José", "Puntarenas", 95);
        grafo.agregarArista("San José", "Limón", 160);
        grafo.agregarArista("Alajuela", "Heredia", 11);
        grafo.agregarArista("Alajuela", "Cartago", 42);
        grafo.agregarArista("Alajuela", "Liberia", 191);
        grafo.agregarArista("Alajuela", "Puntarenas", 83);
        grafo.agregarArista("Alajuela", "Limón", 168);
        grafo.agregarArista("Heredia", "Cartago", 34);
        grafo.agregarArista("Heredia", "Liberia", 201);
        grafo.agregarArista("Heredia", "Puntarenas", 93);
        grafo.agregarArista("Heredia", "Limón", 157);
        grafo.agregarArista("Cartago", "Liberia", 229);
        grafo.agregarArista("Cartago", "Puntarenas", 121);
        grafo.agregarArista("Cartago", "Limón", 140);
        grafo.agregarArista("Liberia", "Puntarenas", 134);
        grafo.agregarArista("Liberia", "Limón", 347);
        grafo.agregarArista("Puntarenas", "Limón", 249);

        // Unir los cantones de Alajuela con el cantón central
        grafo.agregarArista("Alajuela", "San Ramón", 42);
        grafo.agregarArista("Alajuela", "Grecia", 18);
        grafo.agregarArista("Alajuela", "San Mateo", 45);
        grafo.agregarArista("Alajuela", "Atenas", 30);
        grafo.agregarArista("Alajuela", "Naranjo", 28);
        grafo.agregarArista("Alajuela", "Palmares", 35);
        grafo.agregarArista("Alajuela", "Poás", 13);
        grafo.agregarArista("Alajuela", "Orotina", 45);
        grafo.agregarArista("Alajuela", "San Carlos", 77);
        grafo.agregarArista("Alajuela", "Zarcero", 67);
        grafo.agregarArista("Alajuela", "Valverde Vega", 32);
        grafo.agregarArista("Alajuela", "Upala", 119);
        grafo.agregarArista("Alajuela", "Los Chiles", 134);
        grafo.agregarArista("Alajuela", "Guatuso", 102);
        grafo.agregarArista("Alajuela", "Río Cuarto", 36);

        // Unir los cantones de Cartago con el cantón central
        grafo.agregarArista("Cartago", "Paraíso", 8);
        grafo.agregarArista("Cartago", "La Unión", 15);
        grafo.agregarArista("Cartago", "Jiménez", 30);
        grafo.agregarArista("Cartago", "Turrialba", 43);
        grafo.agregarArista("Cartago", "Alvarado", 10);
        grafo.agregarArista("Cartago", "Oreamuno", 6);
        grafo.agregarArista("Cartago", "El Guarco", 8);

        // Unir los cantones de Heredia con el cantón central
        grafo.agregarArista("Heredia", "Barva", 4);
        grafo.agregarArista("Heredia", "Santo Domingo", 6);
        grafo.agregarArista("Heredia", "Santa Bárbara", 9);
        grafo.agregarArista("Heredia", "San Rafael", 7);
        grafo.agregarArista("Heredia", "San Isidro", 8);
        grafo.agregarArista("Heredia", "Belén", 8);
        grafo.agregarArista("Heredia", "Flores", 6);
        grafo.agregarArista("Heredia", "San Pablo", 4);
        grafo.agregarArista("Heredia", "Sarapiquí", 82);

        // Unir los cantones de Guanacaste con el cantón central
        grafo.agregarArista("Liberia", "Nicoya", 75);
        grafo.agregarArista("Liberia", "Santa Cruz", 55);
        grafo.agregarArista("Liberia", "Bagaces", 30);
        grafo.agregarArista("Liberia", "Carrillo", 20);
        grafo.agregarArista("Liberia", "Cañas", 75);
        grafo.agregarArista("Liberia", "Abangares", 105);
        grafo.agregarArista("Liberia", "Tilarán", 95);
        grafo.agregarArista("Liberia", "Nandayure", 105);
        grafo.agregarArista("Liberia", "La Cruz", 44);
        grafo.agregarArista("Liberia", "Hojancha", 110);
        grafo.agregarArista("Liberia", "Monteverde", 140);

        // Unir los cantones de Puntarenas con el cantón central
        grafo.agregarArista("Puntarenas", "Esparza", 20);
        grafo.agregarArista("Puntarenas", "Buenos Aires", 170);
        grafo.agregarArista("Puntarenas", "Montes de Oro", 25);
        grafo.agregarArista("Puntarenas", "Osa", 180);
        grafo.agregarArista("Puntarenas", "Quepos", 160);
        grafo.agregarArista("Puntarenas", "Golfito", 300);
        grafo.agregarArista("Puntarenas", "Coto Brus", 255);
        grafo.agregarArista("Puntarenas", "Parrita", 120);
        grafo.agregarArista("Puntarenas", "Corredores", 340);
        grafo.agregarArista("Puntarenas", "Garabito", 70);
        grafo.agregarArista("Puntarenas", "Puerto Jiménez", 360);

        // Unir los cantones de Limón con el cantón central
        grafo.agregarArista("Limón", "Pococí", 65);
        grafo.agregarArista("Limón", "Siquirres", 62);
        grafo.agregarArista("Limón", "Talamanca", 75);
        grafo.agregarArista("Limón", "Matina", 40);
        grafo.agregarArista("Limón", "Guácimo", 80);

        //Unir los cantones con su cantón vecino más cercano

        //San José
        grafo.agregarArista("Escazú", "Santa Ana", 7);
        grafo.agregarArista("Desamparados", "Aserrí", 11);
        grafo.agregarArista("Puriscal", "Turrubares", 26);
        grafo.agregarArista("Tarrazú", "Dota", 20);
        grafo.agregarArista("Aserrí", "Acosta", 15);
        grafo.agregarArista("Mora", "Santa Ana", 12);
        grafo.agregarArista("Goicoechea", "Moravia", 4);
        grafo.agregarArista("Alajuelita", "Escazú", 10);
        grafo.agregarArista("Vázquez de Coronado", "Moravia", 7);
        grafo.agregarArista("Tibás", "Santo Domingo", 6);
        grafo.agregarArista("Montes de Oca", "Curridabat", 5);
        grafo.agregarArista("León Cortés", "Dota", 18);
        grafo.agregarArista("Pérez Zeledón", "Buenos Aires", 40);

        //Alajuela
        grafo.agregarArista("San Ramón", "Palmares", 9);
        grafo.agregarArista("Grecia", "Valverde Vega", 10);
        grafo.agregarArista("San Mateo", "Atenas", 14);
        grafo.agregarArista("Atenas", "Orotina", 24);
        grafo.agregarArista("Naranjo", "Palmares", 8);
        grafo.agregarArista("Poás", "Grecia", 16);
        grafo.agregarArista("San Carlos", "Río Cuarto", 35);
        grafo.agregarArista("Zarcero", "Naranjo", 23);
        grafo.agregarArista("Upala", "Guatuso", 38);
        grafo.agregarArista("Los Chiles", "Guatuso", 55);
        grafo.agregarArista("Guatuso", "San Carlos", 58);

        //Cartago
        grafo.agregarArista("Paraíso", "Jiménez", 18);
        grafo.agregarArista("La Unión", "Curridabat", 7);
        grafo.agregarArista("Jiménez", "Turrialba", 22);
        grafo.agregarArista("Alvarado", "Oreamuno", 7);
        grafo.agregarArista("El Guarco", "Desamparados", 20);

        //Heredia
        grafo.agregarArista("Barva", "San Rafael", 5);
        grafo.agregarArista("Santo Domingo", "Tibás", 6);
        grafo.agregarArista("Santa Bárbara", "Barva", 6);
        grafo.agregarArista("San Isidro", "Vázquez de Coronado", 12);
        grafo.agregarArista("Belén", "Flores", 4);
        grafo.agregarArista("San Pablo", "Santo Domingo", 3);
        grafo.agregarArista("Sarapiquí", "San Carlos", 32);

        //Guanacaste
        grafo.agregarArista("Nicoya", "Santa Cruz", 30);
        grafo.agregarArista("Santa Cruz", "Carrillo", 25);
        grafo.agregarArista("Bagaces", "Cañas", 30);
        grafo.agregarArista("Abangares", "Tilarán", 32);
        grafo.agregarArista("Cañas", "Tilarán", 25);
        grafo.agregarArista("Nandayure", "Hojancha", 18);
        grafo.agregarArista("Monteverde", "Tilarán", 35);

        //Puntarenas
        grafo.agregarArista("Esparza", "Montes de Oro", 15);
        grafo.agregarArista("Buenos Aires", "Coto Brus", 45);
        grafo.agregarArista("Osa", "Golfito", 60);
        grafo.agregarArista("Quepos", "Parrita", 30);
        grafo.agregarArista("Golfito", "Corredores", 35);
        grafo.agregarArista("Parrita", "Garabito", 45);
        grafo.agregarArista("Puerto Jiménez", "Golfito", 75);

        //Limón
        grafo.agregarArista("Pococí", "Guácimo", 22);
        grafo.agregarArista("Siquirres", "Guácimo", 27);
        grafo.agregarArista("Talamanca", "Limón", 75);
        grafo.agregarArista("Matina", "Siquirres", 35);

        return grafo;
    }
}