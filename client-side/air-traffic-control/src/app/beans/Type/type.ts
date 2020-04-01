export class Type {

  private id: number;
  priority: number;
  private name: string;


  constructor($id: number, $priority: number, $name: string) {
    this.id = $id;
    this.priority = $priority;
    this.name = $name;
  }

  /**
   * Getter $id
   * @return {number}
   */
  public get $id(): number {
    return this.id;
  }

  /**
   * Setter $id
   * @param {number} value
   */
  public set $id(value: number) {
    this.id = value;
  }

  /**
   * Getter $priority
   * @return {number}
   */
  public get $priority(): number {
    return this.priority;
  }

  /**
   * Setter $priority
   * @param {number} value
   */
  public set $priority(value: number) {
    this.priority = value;
  }

  /**
   * Getter $name
   * @return {string}
   */
  public get $name(): string {
    return this.name;
  }

  /**
   * Setter $name
   * @param {string} value
   */
  public set $name(value: string) {
    this.name = value;
  }

}
