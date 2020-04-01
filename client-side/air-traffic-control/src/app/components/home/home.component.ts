import { Component, OnInit, ɵConsole } from '@angular/core';
import { Observable } from 'rxjs';
import { Aircraft } from 'src/app/beans/Aircraft/aircraft';
import { Size } from 'src/app/beans/Size/size';
import { Type } from 'src/app/beans/Type/type';
import { HttpService } from 'src/app/services/http.service';
import { AircraftService } from 'src/app/services/aircraft/aircraft.service';
import { TypeService } from 'src/app/services/type/type.service';
import { SizeService } from 'src/app/services/size/size.service';
import { MatTableDataSource } from '@angular/material/table';
import { MatSort } from '@angular/material/sort';

@Component({
  selector: 'atc-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  running = false;
  nums = [0, 0, 0, 0]; // 0 = Pass, 1 = Cargo, 2 = Small, 3 = Large
  // nums = new Map<string, number>();
  numSource = [this.nums];
  type: Type;
  size: Size;
  aircraft = [];
  types = [];
  sizes = [];
  displayedColumns = ['id', 'type', 'size'];
  numColumns = ['numAC', 'numPass', 'numCargo', 'numSmall', 'numLarge'];
  acObsv: Observable<object>;
  acDataSource = new MatTableDataSource<Aircraft>();

  constructor(private acAPI: AircraftService, private typeAPI: TypeService, private sizeAPI: SizeService) { }

  ngOnInit(): void {
    this.getTypes();
    this.getSizes();
    this.getAircraft();
    // this.nums.set('Passenger', 0);
    // this.nums.set('Cargo', 0);
    // this.nums.set('Small', 0);
    // this.nums.set('Large', 0);
  }

  /**
   * Retrieve all Types from using the TypeService
   */
  getTypes() {
    this.typeAPI.getAll()
      .subscribe(
        (succ: Array<Type>) => {
          this.types = succ;
        }
      );
  }

  /**
   * Retrive all Sizes using the SizeService
   */
  getSizes() {
    this.sizeAPI.getAll()
      .subscribe(
        (succ: Array<Size>) => {
          this.sizes = succ;
        }
      );
  }

  /**
   * Retrieve all Aircraft using the AircraftService and then sort them by queue priority using getPriority() and set the queue status
   * using getStatus()
   */
  getAircraft() {
    this.acObsv = this.acAPI.getAll();
    this.acAPI.getAll()
      .subscribe(
        (succ: Array<Aircraft>) => {
          this.aircraft = succ;
          this.acDataSource.data = succ.sort((ac1: Aircraft, ac2: Aircraft) => {
            return this.getPriority(ac1) - this.getPriority(ac2);
          });
        }
      );
  }

  /**
   * Sort the main data source based on queue priority
   */
  sort() {
    this.acDataSource.data.sort((ac1: Aircraft, ac2: Aircraft) => {
      return this.getPriority(ac1) - this.getPriority(ac2);
    });
  }

  /**
   * Add a new Aircraft to the queue and sort it into position for UI purposes
   */
  enqueue() {
    const newAC = new Aircraft(0, this.type, this.size);
    this.acAPI.save(newAC).subscribe(succ => {
      this.aircraft.push(succ);
      this.acDataSource.data = this.aircraft;
    });
    this.acDataSource.data = this.aircraft;
    this.sort();
  }

  /**
   * Remove a single Aircraft based on priority reqwuirements ans then sort for
   */
  dequeue() {
    const deletedAC = this.aircraft.sort((ac1: Aircraft, ac2: Aircraft) => {
      return this.getPriority(ac1) - this.getPriority(ac2);
    }).shift();
    this.acAPI.delete('id', deletedAC.id).subscribe(succ => {
      this.acDataSource.data = this.aircraft;
      // this.sort();
    });
  }

  /**
   * Calculate the priorty value of a given Aircraft, lower = higher priority
   *
   * @param ac
   */
  getPriority(ac: Aircraft): number {
    return (10 * ac.type.priority) + ac.size.priority;
  }

}
