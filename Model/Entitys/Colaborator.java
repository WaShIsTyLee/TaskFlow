package Model.Entitys;

import Interfaces.iColaborador;
import Model.Proyectos.Proyectos;

import java.io.Serial;
import java.io.Serializable;

public class Colaborator extends User implements iColaborador, Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

        /**
         * Metodos relacionados con el manejo de la clase colaborador dentro del progrma.
         */

        private String Usuario;

        public Colaborator(String usuario) {
            Usuario = usuario;
        }

        public String getUsuario() {
            return Usuario;
        }

        public void setUsuario(String usuario) {
            Usuario = usuario;
        }


        @Override
        public String toString() {
            return Usuario;
        }


        public static Colaborator findCollaborator(Proyectos aux, User user) {
            Colaborator colaboradora = null;
            for (Colaborator colaborator : aux.getColaborador()) {
                if (user.getNombre().equals(colaborator.getUsuario())) {
                    colaboradora = colaborator;
                    /**
                     *
                     * @param aux un proyecto declarado como dato auxiliar
                     * @param usuario un usuario
                     * @return
                     */
                                   }
                        }
                        System.out.println(colaboradora);
                        return colaboradora;
                    }

                }