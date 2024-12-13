import { Injectable } from '@angular/core';
import axios from 'axios';

@Injectable({
  providedIn: 'root'
})
export class MenuService {

  constructor() { }

  getMenues() {
    return axios.get('http://localhost:8086/api/menu');
  }
}
