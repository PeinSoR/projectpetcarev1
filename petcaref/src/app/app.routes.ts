// 📁 petcaref/src/app/app.routes.ts

import { Routes } from '@angular/router';

// 1. IMPORTAMOS LAS CLASES (¡SIN EL SUFIJO 'Component'!)
import { Login } from './pages/login/login';
import { Registro } from './pages/registro/registro';
import { Dashboard } from './pages/dashboard/dashboard';
import { MisMascotas } from './pages/mis-mascotas/mis-mascotas';
import { Adopciones } from './pages/adopciones/adopciones';
import { Finanzas } from './pages/finanzas/finanzas';
import { RedVecinal } from './pages/red-vecinal/red-vecinal';
import { Perfil } from './pages/perfil/perfil';

// 2. DEFINIMOS EL "MAPA" DE LA APLICACIÓN
export const routes: Routes = [
  { path: 'login', component: Login }, // <-- Usamos la clase simple
  { path: 'registro', component: Registro }, // <-- Usamos la clase simple
  { path: 'dashboard', component: Dashboard }, // <-- ...y así
  { path: 'mis-mascotas', component: MisMascotas },
  { path: 'adopciones', component: Adopciones },
  { path: 'finanzas', component: Finanzas },
  { path: 'red-vecinal', component: RedVecinal },
  { path: 'perfil', component: Perfil },

  // 3. RUTA POR DEFECTO
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: '**', redirectTo: 'login' }
];
