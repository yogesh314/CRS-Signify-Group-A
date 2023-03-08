import { TestBed } from '@angular/core/testing';

import { PayFeeService } from './pay-fee.service';

describe('PayFeeService', () => {
  let service: PayFeeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PayFeeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
