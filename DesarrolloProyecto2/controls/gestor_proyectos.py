class GestorProyectos:
    def __init__(self):
        self.proyectos = []  # Lista para almacenar los proyectos

    def obtenerTodosLosProyectos(self):
        return self.proyectos

    def agregarProyecto(self, proyecto):
        self.proyectos.append(proyecto)
        return proyecto
