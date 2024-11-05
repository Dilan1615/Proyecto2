from flask import Flask
from routes.route import router

def create_app():
    app = Flask(__name__, instance_relative_config=False)
    with app.app_context():
        from routes.route import router  # Asegúrate de que la importación sea correcta
        app.register_blueprint(router)
    return app

app = create_app()

if __name__ == '__main__':
    app.run(debug=True, host="0.0.0.0")
