import logging
from flask import Blueprint, abort, request, render_template, redirect, url_for
import requests

# Configuración de logging para que muestre errores en la consola
logging.basicConfig(level=logging.ERROR)

router = Blueprint('router', __name__)
API_URL = 'http://localhost:8080/myapp/proyectos'  # Cambia esto si tu API está en otro puerto

@router.route('/')
def home():
    try:
        response = requests.get(API_URL)
        response.raise_for_status()
        proyectos = response.json()
    except requests.exceptions.RequestException as e:
        logging.error(f"Error al conectar con la API Java: {e}")
        proyectos = []
    return render_template('index.html', proyectos=proyectos)

@router.route('/proyectos', methods=['POST'])
def create_proyecto():
    try:
        nombre = request.form.get('nombre')
        inversion = request.form.get('inversion')
        fechaInicioConstruccion = request.form.get('fechaInicioConstruccion')
        fechaFinConstruccion = request.form.get('fechaFinConstruccion')
        tiempoVida = request.form.get('tiempoVida')
        inversionistas = request.form.get('inversionistas')
        electricidadGeneradaPorDia = request.form.get('electricidadGeneradaPorDia')
        ubicacion = request.form.get('ubicacion')
        tipoEnergia = request.form.get('tipoEnergia')

        nuevo_proyecto = {
            "nombre": nombre,
            "inversion": inversion,
            "fechaInicioConstruccion": fechaInicioConstruccion,
            "fechaFinConstruccion": fechaFinConstruccion,
            "tiempoVida": tiempoVida,
            "inversionistas": inversionistas.split(','),  # Asegúrate de enviar una lista
            "electricidadGeneradaPorDia": electricidadGeneradaPorDia,
            "ubicacion": ubicacion,
            "tipoEnergia": tipoEnergia,
        }

        response = requests.post(API_URL, json=nuevo_proyecto)
        response.raise_for_status()  # Genera una excepción si el código de estado no es exitoso
        return redirect(url_for('router.home'))  # Redirige a la página de inicio después de crear el proyecto
    except requests.exceptions.RequestException as e:
        logging.error(f"Error al crear el proyecto en la API Java: {e}")
        abort(500)  # Si hay un error, muestra un error 500 en la página
