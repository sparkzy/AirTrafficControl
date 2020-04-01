import { Type } from '../Type/type';
import { Size } from '../Size/size';

export class Aircraft {

  id: number;
  type: Type;
  size: Size;

  constructor($id: number, $type: Type, $size: Size) {
    this.id = $id;
    this.type = $type;
    this.size = $size;
  }

}
