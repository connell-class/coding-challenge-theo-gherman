import { TestBed } from '@angular/core/testing';

import { ItemGetterService } from './item-getter.service';

describe('ItemGetterService', () => {
  let service: ItemGetterService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ItemGetterService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
